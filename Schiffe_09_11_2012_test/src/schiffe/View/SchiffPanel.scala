package schiffe.View
import javax.swing.ImageIcon
import scala.swing.GridPanel
import scala.swing.Button
import java.awt.Dimension
import scala.swing.Action
import scala.swing.event.ButtonClicked
import scala.swing._
import scala.swing.event.Event

case class SetSchiff(laenge: Int) extends Event
class SchiffPanel(size: Int) extends Publisher{
  
  def setButtonsVisible = {
    for(i <- 0 to schiffleiste.contents.length){
      schiffleiste.contents(i).visible_=(true)
    }
    
          
  }
  var aktuelleLaenge = 0
  var aktuellerButton = new Button
  var schlachtschiff_icon = new ImageIcon("images/Schlachtschiff.png")
  var kreuzer_icon = new ImageIcon("images/Kreuzer.png")
  var uboot_icon = new ImageIcon("images/UBoot.png")
  var zerstoerer_icon = new ImageIcon("images/Zerstoerer.png")
  var z_einzeln = false
  var z = false
        var u = false
        var k = false
         var z1_gross = false
        var z2_gross = false
        var z3_gross = false
        var z4_gross = false
        var u1_gross = false
        var u2_gross = false
        var u3_gross = false
        var k1_gross = false
        var k2_gross = false
        var s_gross = false

  def schiffleiste: GridPanel = {
    size match {
      case 2 =>
        
        var schiffleiste = new GridPanel(1, 1) {
          background = java.awt.Color.WHITE
          var zerstoerer_einzeln = new Button("Zerstoerer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))

            reactions += {
              case ButtonClicked(zerstoerer_einzeln) =>
                if (z_einzeln == false) {
                  zerstoerer_einzeln.background_=(java.awt.Color.RED)
                  zerstoerer_einzeln.preferredSize_=(new Dimension(300, 60))
                  publish(new SetSchiff(2))
                  aktuelleLaenge = 2
                  aktuellerButton = this
                  z_einzeln = true
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  z_einzeln = false
                }
            }
          }

          zerstoerer_einzeln.icon = zerstoerer_icon

          contents += zerstoerer_einzeln
          listenTo(zerstoerer_einzeln)
        }
        schiffleiste
      case 5 =>
        var zerstoerer = new Button
        var uboot = new Button
        var kreuzer = new Button
        var schiffleiste = new GridPanel(3, 1) {
          background = java.awt.Color.WHITE
           zerstoerer = new Button("Zerstoerer"){
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
          
            reactions += {
              case ButtonClicked(zerstoerer) =>
                if (z == false) {
                  zerstoerer.background_=(java.awt.Color.RED)
                  zerstoerer.preferredSize_=(new Dimension(350, 60))
                  publish(new SetSchiff(2))
                  aktuelleLaenge = 2
                  reset(kreuzer)
                  reset(uboot)
                  aktuellerButton = this
                  k = false
                  u = false
                  z = true
                } else {
                  zerstoerer.background = java.awt.Color.WHITE
                  zerstoerer.preferredSize_=(new Dimension(350, 60))
                  z = false
                }
            }
          icon = zerstoerer_icon
          }


          contents += zerstoerer
          listenTo(zerstoerer)
          uboot = new Button("U-Boot") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
          
            reactions += {
              case ButtonClicked(uboot) =>
                if (u == false) {
                	
                  reset(kreuzer)
                  reset(zerstoerer)
                 uboot. background_=(java.awt.Color.RED)
                  uboot.preferredSize_=(new Dimension(300, 60))
                 publish(new SetSchiff(3))
                 aktuellerButton = this
                 aktuelleLaenge = 3
                  z = false
                  k = false
                  u = true
                } else {
                  uboot.background = java.awt.Color.WHITE
                  uboot.preferredSize_=(new Dimension(350, 60))
                  u = false
                }
                
            }
          icon = uboot_icon
        }
          contents += uboot
          listenTo(uboot)
          kreuzer = new Button("Kreuzer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
          
            reactions += {
              case ButtonClicked(kreuzer) =>
                if (k == false) {
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  reset(uboot)
                reset(zerstoerer)
                aktuellerButton = this
                  aktuelleLaenge = 4
                  z = false
                  u = false
                  k = true
                } else {
                  background_=(java.awt.Color.WHITE)
                  preferredSize_=(new Dimension(350, 60))
                  k = false
                }
            }
            icon = kreuzer_icon
          }          
          

          contents += kreuzer
          listenTo(kreuzer)
        }
        schiffleiste
      case 10 =>
        var schlachtschiff_gross = new Button
           var kreuzer_2_gross = new Button
          var kreuzer_1_gross = new Button
          var uboot_3_gross = new Button
          var uboot_2_gross = new Button
           var uboot_1_gross = new Button
          var zerstoerer_4_gross = new Button
           var zerstoerer_3_gross = new Button
          var zerstoerer_2_gross = new Button
          var zerstoerer_1_gross = new Button
          
        var schiffleiste = new GridPanel(10, 1) {
          background = java.awt.Color.WHITE
          zerstoerer_1_gross = new Button("1.ter Zerstoerer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(zerstoerer_1_gross) =>
                if (z1_gross == false) {
                  aktuelleLaenge = 2
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  reset(zerstoerer_2_gross)
                  reset(zerstoerer_3_gross)
                  reset(zerstoerer_4_gross)
                  reset(uboot_1_gross)
                  reset(uboot_2_gross)
                  reset(uboot_3_gross)
                  reset(kreuzer_1_gross)
                  reset(kreuzer_2_gross)
                  reset(schlachtschiff_gross)
                  aktuellerButton = this
                  aktuelleLaenge = 2
                  z1_gross = true
                  z2_gross = false
                  z3_gross = false
                  z4_gross = false
                  u1_gross = false
                  u2_gross = false
                  u3_gross = false
                  k1_gross = false
                  k2_gross = false
                  s_gross = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  z1_gross = false
                }
            }
            icon = zerstoerer_icon
          }
          
          contents += zerstoerer_1_gross
          listenTo(zerstoerer_1_gross)
          
          
           
          zerstoerer_2_gross = new Button("2.ter Zerstoerer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(zerstoerer_2_gross) =>
                if (z2_gross == false) {
                  aktuelleLaenge = 2
                  reset(zerstoerer_1_gross)
                  reset(zerstoerer_3_gross)
                  reset(zerstoerer_4_gross)
                  reset(uboot_1_gross)
                  reset(uboot_2_gross)
                  reset(uboot_3_gross)
                  reset(kreuzer_1_gross)
                  reset(kreuzer_2_gross)
                  reset(schlachtschiff_gross)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  z1_gross = false
                  z2_gross = true
                  z3_gross = false
                  z4_gross = false
                  u1_gross = false
                  u2_gross = false
                  u3_gross = false
                  k1_gross = false
                  k2_gross = false
                  s_gross = false
                  
                aktuellerButton = this
                  aktuelleLaenge = 2
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  z2_gross = false
                }
            }
            icon = zerstoerer_icon
          }
          
          contents += zerstoerer_2_gross
          listenTo(zerstoerer_2_gross)
          
          
          
          zerstoerer_3_gross = new Button("3.ter Zerstoerer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(zerstoerer_3_gross) =>
                if (z3_gross == false) {
                  aktuelleLaenge = 2
                  reset(zerstoerer_1_gross)
                  reset(zerstoerer_2_gross)
                  reset(zerstoerer_4_gross)
                  reset(uboot_1_gross)
                  reset(uboot_2_gross)
                  reset(uboot_3_gross)
                  reset(kreuzer_1_gross)
                  reset(kreuzer_2_gross)
                  reset(schlachtschiff_gross)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  aktuellerButton = this
                  aktuelleLaenge = 2
                  z1_gross = false
                  z2_gross = false
                  z3_gross = true
                  z4_gross = false
                  u1_gross = false
                  u2_gross = false
                  u3_gross = false
                  k1_gross = false
                  k2_gross = false
                  s_gross = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  z3_gross = false
                }
            }
            icon = zerstoerer_icon
          }
          
          contents += zerstoerer_3_gross
          listenTo(zerstoerer_3_gross)
          
         
          
          zerstoerer_4_gross = new Button("4.ter Zerstoerer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(zerstoerer_4_gross) =>
                if (z4_gross == false) {
                  aktuelleLaenge = 2
                  reset(zerstoerer_1_gross)
                  reset(zerstoerer_2_gross)
                  reset(zerstoerer_3_gross)
                  reset(uboot_1_gross)
                  reset(uboot_2_gross)
                  reset(uboot_3_gross)
                  reset(kreuzer_1_gross)
                  reset(kreuzer_2_gross)
                  reset(schlachtschiff_gross)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  aktuellerButton = this
                  aktuelleLaenge = 2
                  z1_gross = false
                  z2_gross = false
                  z3_gross = false
                  z4_gross = true
                  u1_gross = false
                  u2_gross = false
                  u3_gross = false
                  k1_gross = false
                  k2_gross = false
                  s_gross = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  z4_gross = false
                }
            }
            icon = zerstoerer_icon
          }
          
          contents += zerstoerer_4_gross
          listenTo(zerstoerer_4_gross)
          
          
          
           
          uboot_1_gross = new Button("1.tes U-Boot") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(uboot_1_gross) =>
                if (u1_gross == false) {
                  aktuelleLaenge = 3
                  reset(zerstoerer_1_gross)
                  reset(zerstoerer_2_gross)
                  reset(zerstoerer_3_gross)
                  reset(zerstoerer_4_gross)
                  
                  reset(uboot_2_gross)
                  reset(uboot_3_gross)
                  reset(kreuzer_1_gross)
                  reset(kreuzer_2_gross)
                  reset(schlachtschiff_gross)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  aktuellerButton = this
                  aktuelleLaenge = 3
                  z1_gross = false
                  z2_gross = false
                  z3_gross = false
                  z4_gross = false
                  u1_gross = true
                  u2_gross = false
                  u3_gross = false
                  k1_gross = false
                  k2_gross = false
                  s_gross = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  u1_gross = false
                }
            }
            icon = uboot_icon
          }
          

           
          
          contents += uboot_1_gross
          listenTo(uboot_1_gross)
          uboot_2_gross = new Button("2.tes U-Boot") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(uboot_2_gross) =>
                if (u2_gross == false) {
                  aktuelleLaenge = 3
                  reset(zerstoerer_1_gross)
                  reset(zerstoerer_2_gross)
                  reset(zerstoerer_3_gross)
                  reset(zerstoerer_4_gross)
                  
                  reset(uboot_1_gross)
                  reset(uboot_3_gross)
                  reset(kreuzer_1_gross)
                  reset(kreuzer_2_gross)
                  reset(schlachtschiff_gross)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  aktuellerButton = this
                  aktuelleLaenge = 3
                  z1_gross = false
                  z2_gross = false
                  z3_gross = false
                  z4_gross = false
                  u1_gross = false
                  u2_gross = true
                  u3_gross = false
                  k1_gross = false
                  k2_gross = false
                  s_gross = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  u2_gross = false
                }
            }
            icon = uboot_icon
          }
          

          
         
          
          contents += uboot_2_gross
          listenTo(uboot_2_gross)
          uboot_3_gross = new Button("3.tes U-Boot") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(uboot_3_gross) =>
                if (u3_gross == false) {
                  aktuelleLaenge = 3
                  reset(zerstoerer_1_gross)
                  reset(zerstoerer_2_gross)
                  reset(zerstoerer_3_gross)
                  reset(zerstoerer_4_gross)
                  
                  reset(uboot_1_gross)
                  reset(uboot_2_gross)
                  reset(kreuzer_1_gross)
                  reset(kreuzer_2_gross)
                  reset(schlachtschiff_gross)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  aktuellerButton = this
                  aktuelleLaenge = 3
                  z1_gross = false
                  z2_gross = false
                  z3_gross = false
                  z4_gross = false
                  u1_gross = false
                  u2_gross = false
                  u3_gross = true
                  k1_gross = false
                  k2_gross = false
                  s_gross = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  u3_gross = false
                }
            }
            icon = uboot_icon
          }
          

          
          
          contents += uboot_3_gross
          listenTo(uboot_3_gross)
          kreuzer_1_gross = new Button("1.ter Kreuzer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(kreuzer_1_gross) =>
                if (k1_gross == false) {
                  aktuelleLaenge = 4
                  reset(zerstoerer_1_gross)
                  reset(zerstoerer_2_gross)
                  reset(zerstoerer_3_gross)
                  reset(zerstoerer_4_gross)
                  reset(uboot_1_gross)
                  reset(uboot_2_gross)
                  reset(uboot_3_gross)
                  
                  reset(kreuzer_2_gross)
                  reset(schlachtschiff_gross)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  aktuellerButton = this
                  aktuelleLaenge = 4
                  z1_gross = false
                  z2_gross = false
                  z3_gross = false
                  z4_gross = false
                  u1_gross = false
                  u2_gross = false
                  u3_gross = false
                  k1_gross = true
                  k2_gross = false
                  s_gross = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  k1_gross = false
                }
            }
            icon = kreuzer_icon
          }
          

          
           
          contents += kreuzer_1_gross
          listenTo(kreuzer_1_gross)
          kreuzer_2_gross = new Button("2.ter Kreuzer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(kreuzer_2_gross) =>
                if (k2_gross == false) {
                  aktuelleLaenge = 4
                  reset(zerstoerer_1_gross)
                  reset(zerstoerer_2_gross)
                  reset(zerstoerer_3_gross)
                  reset(zerstoerer_4_gross)
                  reset(uboot_1_gross)
                  reset(uboot_2_gross)
                  reset(uboot_3_gross)
                  
                  reset(kreuzer_1_gross)
                  reset(schlachtschiff_gross)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  aktuellerButton = this
                  aktuelleLaenge = 4
                  z1_gross = false
                  z2_gross = false
                  z3_gross = false
                  z4_gross = false
                  u1_gross = false
                  u2_gross = false
                  u3_gross = false
                  k1_gross = false
                  k2_gross = true
                  s_gross = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  k2_gross = false
                }
            }
            icon = kreuzer_icon
          }
          

          contents += kreuzer_2_gross
          listenTo(kreuzer_2_gross)
          schlachtschiff_gross = new Button("Schlachtschiff") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(schlachtschiff_gross) =>
                if (s_gross == false) {
                  aktuelleLaenge = 5
                  reset(zerstoerer_1_gross)
                  reset(zerstoerer_2_gross)
                  reset(zerstoerer_3_gross)
                  reset(zerstoerer_4_gross)
                  reset(uboot_1_gross)
                  reset(uboot_2_gross)
                  reset(uboot_3_gross)
                  reset(kreuzer_1_gross)
                  reset(kreuzer_2_gross)
                  
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  aktuellerButton = this
                  aktuelleLaenge = 5
                  z1_gross = false
                  z2_gross = false
                  z3_gross = false
                  z4_gross = false
                  u1_gross = false
                  u2_gross = false
                  u3_gross = false
                  k1_gross = false
                  k2_gross = false
                  s_gross = true
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  s_gross = false
                }
            }
            icon = schlachtschiff_icon
          }
          
          contents += schlachtschiff_gross
          listenTo(schlachtschiff_gross)
        }

        schiffleiste
    }
  }
 def reset(button: AbstractButton): Unit = {
   button.background_=(java.awt.Color.WHITE)
   button.preferredSize_=(new Dimension(350, 60))
 }
}