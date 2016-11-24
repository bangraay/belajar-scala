
import scala.xml._

/**
 * A Scala XML XPath example.
 * Author: Alvin Alexander, http://devdaily.com
 */
object ScalaXmlXpathExample extends App {

  println(getReceipt(getXml))

  def getReceipt(xml: Elem): String = {
    val sb = new StringBuilder
    sb.append(getLineItemsReceiptString(xml))
    sb.append(getTaxItemsReceiptString(xml))
    sb.append(getTotalLineForReceipt(xml))
    sb.toString
  }
  
  def getLineItemsReceiptString(xml: Elem) = {
    buildReceiptString(getOrderItems(xml), getOrderItemNameAndPrice)
  }
  
  def getTaxItemsReceiptString(xml: Elem) = {
    buildReceiptString(getTaxItems(xml), getTaxItemNameAndAmount)
  }
  
  def getTotalLineForReceipt(xml: Elem) = {
    "%-30s  %6.2f\n".format("TOTAL:", getTotalPrice(getOrderItems(xml), getTaxItems(xml)))
  }
  
  def getOrderItems(rootNode: Elem) = rootNode \ "item"
  def getTaxItems(rootNode: Elem) = rootNode \ "tax"

  // can reuse the other methods, or make these calls.
  // specifying Double as the return type here is needed, otherwise Scala
  // will make it a BoxedUnit.
  def getTotalPrice(items: NodeSeq, taxItems: NodeSeq): Double = {
    val priceWithoutTax = items.map(i => (i \ "@price").text.toDouble).sum
    val totalTax = taxItems.map(i => i.text.toDouble).sum
    priceWithoutTax + totalTax
  }
  
  // items can be orderItems or taxItems; the function 'f' should
  // correspond to that data type (getOrderItemNameAndPrice or getTaxItemNameAndAmount).
  def buildReceiptString(items: NodeSeq, f:(Node) => (String, Double)) = {
    val sb = new StringBuilder
    items.foreach{ i =>
      val (name, value) = f(i)
      sb.append("%-30s  %6.2f\n".format(name, value))
    }
    sb.toString
  }
  
  def getOrderItemNameAndPrice(itemNode: Node) = {
    val name = getDisplayableOrderItemName(itemNode)
    val price = (itemNode \ "@price").text.toDouble
    (name, price)
  }
  
  def getDisplayableOrderItemName(itemNode: Node): String = {
    getItemName(itemNode) match {
      case "Pizza" => getPizzaNameForReceipt(itemNode)
      case "Breadsticks" => getBreadsticksNameForReceipt(itemNode)
      case _ => "other"
    }
  }
  
  def getTaxItemNameAndAmount(taxNode: Node) = {
    val name = getDisplayableTaxItemName(taxNode)
    val amount = taxNode.text.toDouble
    (name, amount)
  }
  
  def getDisplayableTaxItemName(taxNode: Node) = {
    getTaxItemName(taxNode) match {
      case "local" => "Local Tax"
      case "state" => "State Tax"
      case "federal" => "Federal Tax"
      case _ => "Unknown Tax"
    }
  }

  def getTaxItemName(taxNode: Node) = (taxNode \ "@type").text
  def getItemName(itemNode: Node) = (itemNode \ "@name").text
  def getBreadsticksNameForReceipt(item: Node) = "Breadsticks"

  // want a name like: 12" Thin (Cheese, Sausage)
  def getPizzaNameForReceipt(itemNode: Node) = {
    val pizzaNode = (itemNode \ "pizza")(0)
    val crust = getPizzaCrust(pizzaNode)
    val size = getPizzaSize(pizzaNode)
    "%2d %s %s".format(size, crust, getPizzaToppingsForReceipt(pizzaNode))
  }
  
  def getPizzaToppingsForReceipt(pizzaNode: Node) = {
    getToppings(pizzaNode).map(_.capitalize).mkString("(", ", ", ")")
  }
  
  def getToppings(pizzaNode: Node) = (pizzaNode \ "topping").map(_.text)
  def getPizzaCrust(pizzaNode: Node) = (pizzaNode \ "crust" \ "@type").text
  def getPizzaSize(pizzaNode: Node) = (pizzaNode \ "crust" \ "@size").text.toInt
  
  def getXml = {
    <order>
      <item name="Pizza" price="12.00">
        <pizza>
          <crust type="thin" size="14" />
          <topping>cheese</topping>
          <topping>sausage</topping>
        </pizza>
      </item>
      <item name="Breadsticks" price="4.00">
        <breadsticks />
      </item>
      <tax type="federal">0.80</tax>
      <tax type="state">0.80</tax>
      <tax type="local">0.40</tax>
    </order>
  }

}