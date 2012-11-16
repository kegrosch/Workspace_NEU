/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 30.10.12
 * Time: 14:16
 * To change this template use File | Settings | File Templates.
 */
package schiffe
class Cell (row:Int,column:Int){
  var value=" "
  require(List(" ", "O", "S", "X").contains(value))
  var offen=false
  var besetzt=false

  def mkString="("+ row +", "+ column + ") = "+ value

  override  def toString= value.toString.replace('0',' ')
  def assign(v:String) = value=v
  def isOpen =  value!=" "
  def x = row
  def y = column
}
