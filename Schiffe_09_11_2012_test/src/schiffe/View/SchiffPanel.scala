package schiffe.View
import javax.swing.ImageIcon
import scala.swing.GridPanel
import scala.swing.Button
import java.awt.Dimension

class SchiffPanel (size: Int) {
   var schlachtschiff_icon = new ImageIcon("images/Schlachtschiff.png")
  var kreuzer_icon = new ImageIcon("images/Kreuzer.png")
  var uboot_icon = new ImageIcon("images/UBoot.png")
  var zerstoerer_icon = new ImageIcon("images/Zerstoerer.png")
   
 def schiffleiste :GridPanel = {
   size match {
     case 2 => 
       var schiffleiste = new GridPanel(1,1){
         background = java.awt.Color.WHITE
         var zerstoerer = new Button("Zerstörer"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
         zerstoerer.icon = zerstoerer_icon
           
         contents += zerstoerer
       }
       schiffleiste
     case 5 =>
        var schiffleiste = new GridPanel(3,1){
         background = java.awt.Color.WHITE
         var zerstoerer = new Button("Zerstörer"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
         
           zerstoerer.icon = zerstoerer_icon
        
         contents += zerstoerer
         var uboot = new Button("U-Boot"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
           uboot.icon = uboot_icon
         
         contents += uboot
         var kreuzer = new Button("Kreuzer"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
           kreuzer.icon = kreuzer_icon
         
         contents += kreuzer
       }
       schiffleiste
       case 10 =>
        var schiffleiste = new GridPanel(10,1){
         background = java.awt.Color.WHITE
         var zerstoerer_1 = new Button("1.ter Zerstörer"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
         zerstoerer_1.icon = zerstoerer_icon
         contents += zerstoerer_1
         var zerstoerer_2 = new Button("2.ter Zerstörer"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
         zerstoerer_2.icon = zerstoerer_icon
         contents += zerstoerer_2
         var zerstoerer_3 = new Button("3.ter Zerstörer"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
         zerstoerer_3.icon = zerstoerer_icon
         contents += zerstoerer_3
         var zerstoerer_4 = new Button("4.ter Zerstörer"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
         zerstoerer_4.icon = zerstoerer_icon
         contents += zerstoerer_4
         var uboot_1 = new Button("1.tes U-Boot"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
           uboot_1.icon = uboot_icon
         
         contents += uboot_1
         var uboot_2 = new Button("2.tes U-Boot"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
           uboot_2.icon = uboot_icon
         
         contents += uboot_2
         var uboot_3 = new Button("3.tes U-Boot"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
           uboot_3.icon = uboot_icon
         
         contents += uboot_3
         var kreuzer_1 = new Button("1.ter Kreuzer"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
           kreuzer_1.icon = kreuzer_icon
         
         contents += kreuzer_1
         var kreuzer_2 = new Button("2.ter Kreuzer"){
           background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
           kreuzer_2.icon = kreuzer_icon
         
         contents += kreuzer_2
         var schlachtschiff = new Button("Schlachtschiff"){
             background = java.awt.Color.WHITE
        preferredSize_=(new Dimension(350,60))
         }
           schlachtschiff.icon = schlachtschiff_icon
       }
       schiffleiste
   }
   }
}