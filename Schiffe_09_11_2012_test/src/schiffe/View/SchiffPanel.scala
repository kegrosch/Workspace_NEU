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
         var z1_gro� = false
        var z2_gro� = false
        var z3_gro� = false
        var z4_gro� = false
        var u1_gro� = false
        var u2_gro� = false
        var u3_gro� = false
        var k1_gro� = false
        var k2_gro� = false
        var s_gro� = false

  def schiffleiste: GridPanel = {
    size match {
      case 2 =>
        
        var schiffleiste = new GridPanel(1, 1) {
          background = java.awt.Color.WHITE
          var zerstoerer_einzeln = new Button("Zerst�rer") {
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
           zerstoerer = new Button("Zerst�rer"){
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
        var schlachtschiff_gro� = new Button
           var kreuzer_2_gro� = new Button
          var kreuzer_1_gro� = new Button
          var uboot_3_gro� = new Button
          var uboot_2_gro� = new Button
           var uboot_1_gro� = new Button
          var zerstoerer_4_gro� = new Button
           var zerstoerer_3_gro� = new Button
          var zerstoerer_2_gro� = new Button
          var zerstoerer_1_gro� = new Button
          
        var schiffleiste = new GridPanel(10, 1) {
          background = java.awt.Color.WHITE
          zerstoerer_1_gro� = new Button("1.ter Zerst�rer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(zerstoerer_1_gro�) =>
                if (z1_gro� == false) {
                  aktuelleLaenge = 2
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  reset(zerstoerer_2_gro�)
                  reset(zerstoerer_3_gro�)
                  reset(zerstoerer_4_gro�)
                  reset(uboot_1_gro�)
                  reset(uboot_2_gro�)
                  reset(uboot_3_gro�)
                  reset(kreuzer_1_gro�)
                  reset(kreuzer_2_gro�)
                  reset(schlachtschiff_gro�)
                  z1_gro� = true
                  z2_gro� = false
                  z3_gro� = false
                  z4_gro� = false
                  u1_gro� = false
                  u2_gro� = false
                  u3_gro� = false
                  k1_gro� = false
                  k2_gro� = false
                  s_gro� = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  z1_gro� = false
                }
            }
            icon = zerstoerer_icon
          }
          
          contents += zerstoerer_1_gro�
          listenTo(zerstoerer_1_gro�)
          
          
           
          zerstoerer_2_gro� = new Button("2.ter Zerst�rer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(zerstoerer_2_gro�) =>
                if (z2_gro� == false) {
                  aktuelleLaenge = 2
                  reset(zerstoerer_1_gro�)
                  reset(zerstoerer_3_gro�)
                  reset(zerstoerer_4_gro�)
                  reset(uboot_1_gro�)
                  reset(uboot_2_gro�)
                  reset(uboot_3_gro�)
                  reset(kreuzer_1_gro�)
                  reset(kreuzer_2_gro�)
                  reset(schlachtschiff_gro�)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  z1_gro� = false
                  z2_gro� = true
                  z3_gro� = false
                  z4_gro� = false
                  u1_gro� = false
                  u2_gro� = false
                  u3_gro� = false
                  k1_gro� = false
                  k2_gro� = false
                  s_gro� = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  z2_gro� = false
                }
            }
            icon = zerstoerer_icon
          }
          
          contents += zerstoerer_2_gro�
          listenTo(zerstoerer_2_gro�)
          
          
          
          zerstoerer_3_gro� = new Button("3.ter Zerst�rer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(zerstoerer_3_gro�) =>
                if (z3_gro� == false) {
                  aktuelleLaenge = 2
                  reset(zerstoerer_1_gro�)
                  reset(zerstoerer_2_gro�)
                  reset(zerstoerer_4_gro�)
                  reset(uboot_1_gro�)
                  reset(uboot_2_gro�)
                  reset(uboot_3_gro�)
                  reset(kreuzer_1_gro�)
                  reset(kreuzer_2_gro�)
                  reset(schlachtschiff_gro�)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  z1_gro� = false
                  z2_gro� = false
                  z3_gro� = true
                  z4_gro� = false
                  u1_gro� = false
                  u2_gro� = false
                  u3_gro� = false
                  k1_gro� = false
                  k2_gro� = false
                  s_gro� = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  z3_gro� = false
                }
            }
            icon = zerstoerer_icon
          }
          
          contents += zerstoerer_3_gro�
          listenTo(zerstoerer_3_gro�)
          
         
          
          zerstoerer_4_gro� = new Button("4.ter Zerst�rer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(zerstoerer_4_gro�) =>
                if (z4_gro� == false) {
                  aktuelleLaenge = 2
                  reset(zerstoerer_1_gro�)
                  reset(zerstoerer_2_gro�)
                  reset(zerstoerer_3_gro�)
                  reset(uboot_1_gro�)
                  reset(uboot_2_gro�)
                  reset(uboot_3_gro�)
                  reset(kreuzer_1_gro�)
                  reset(kreuzer_2_gro�)
                  reset(schlachtschiff_gro�)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  z1_gro� = false
                  z2_gro� = false
                  z3_gro� = false
                  z4_gro� = true
                  u1_gro� = false
                  u2_gro� = false
                  u3_gro� = false
                  k1_gro� = false
                  k2_gro� = false
                  s_gro� = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  z4_gro� = false
                }
            }
            icon = zerstoerer_icon
          }
          
          contents += zerstoerer_4_gro�
          listenTo(zerstoerer_4_gro�)
          
          
          
           
          uboot_1_gro� = new Button("1.tes U-Boot") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(uboot_1_gro�) =>
                if (u1_gro� == false) {
                  aktuelleLaenge = 3
                  reset(zerstoerer_1_gro�)
                  reset(zerstoerer_2_gro�)
                  reset(zerstoerer_3_gro�)
                  reset(zerstoerer_4_gro�)
                  
                  reset(uboot_2_gro�)
                  reset(uboot_3_gro�)
                  reset(kreuzer_1_gro�)
                  reset(kreuzer_2_gro�)
                  reset(schlachtschiff_gro�)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  z1_gro� = false
                  z2_gro� = false
                  z3_gro� = false
                  z4_gro� = false
                  u1_gro� = true
                  u2_gro� = false
                  u3_gro� = false
                  k1_gro� = false
                  k2_gro� = false
                  s_gro� = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  u1_gro� = false
                }
            }
            icon = uboot_icon
          }
          

           
          
          contents += uboot_1_gro�
          listenTo(uboot_1_gro�)
          uboot_2_gro� = new Button("2.tes U-Boot") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(uboot_2_gro�) =>
                if (u2_gro� == false) {
                  aktuelleLaenge = 3
                  reset(zerstoerer_1_gro�)
                  reset(zerstoerer_2_gro�)
                  reset(zerstoerer_3_gro�)
                  reset(zerstoerer_4_gro�)
                  
                  reset(uboot_1_gro�)
                  reset(uboot_3_gro�)
                  reset(kreuzer_1_gro�)
                  reset(kreuzer_2_gro�)
                  reset(schlachtschiff_gro�)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  z1_gro� = false
                  z2_gro� = false
                  z3_gro� = false
                  z4_gro� = false
                  u1_gro� = false
                  u2_gro� = true
                  u3_gro� = false
                  k1_gro� = false
                  k2_gro� = false
                  s_gro� = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  u2_gro� = false
                }
            }
            icon = uboot_icon
          }
          

          
         
          
          contents += uboot_2_gro�
          listenTo(uboot_2_gro�)
          uboot_3_gro� = new Button("3.tes U-Boot") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(uboot_3_gro�) =>
                if (u3_gro� == false) {
                  aktuelleLaenge = 3
                  reset(zerstoerer_1_gro�)
                  reset(zerstoerer_2_gro�)
                  reset(zerstoerer_3_gro�)
                  reset(zerstoerer_4_gro�)
                  
                  reset(uboot_1_gro�)
                  reset(uboot_2_gro�)
                  reset(kreuzer_1_gro�)
                  reset(kreuzer_2_gro�)
                  reset(schlachtschiff_gro�)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  z1_gro� = false
                  z2_gro� = false
                  z3_gro� = false
                  z4_gro� = false
                  u1_gro� = false
                  u2_gro� = false
                  u3_gro� = true
                  k1_gro� = false
                  k2_gro� = false
                  s_gro� = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  u3_gro� = false
                }
            }
            icon = uboot_icon
          }
          

          
          
          contents += uboot_3_gro�
          listenTo(uboot_3_gro�)
          kreuzer_1_gro� = new Button("1.ter Kreuzer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(kreuzer_1_gro�) =>
                if (k1_gro� == false) {
                  aktuelleLaenge = 4
                  reset(zerstoerer_1_gro�)
                  reset(zerstoerer_2_gro�)
                  reset(zerstoerer_3_gro�)
                  reset(zerstoerer_4_gro�)
                  reset(uboot_1_gro�)
                  reset(uboot_2_gro�)
                  reset(uboot_3_gro�)
                  
                  reset(kreuzer_2_gro�)
                  reset(schlachtschiff_gro�)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  z1_gro� = false
                  z2_gro� = false
                  z3_gro� = false
                  z4_gro� = false
                  u1_gro� = false
                  u2_gro� = false
                  u3_gro� = false
                  k1_gro� = true
                  k2_gro� = false
                  s_gro� = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  k1_gro� = false
                }
            }
            icon = kreuzer_icon
          }
          

          
           
          contents += kreuzer_1_gro�
          listenTo(kreuzer_1_gro�)
          kreuzer_2_gro� = new Button("2.ter Kreuzer") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(kreuzer_2_gro�) =>
                if (k2_gro� == false) {
                  aktuelleLaenge = 4
                  reset(zerstoerer_1_gro�)
                  reset(zerstoerer_2_gro�)
                  reset(zerstoerer_3_gro�)
                  reset(zerstoerer_4_gro�)
                  reset(uboot_1_gro�)
                  reset(uboot_2_gro�)
                  reset(uboot_3_gro�)
                  
                  reset(kreuzer_1_gro�)
                  reset(schlachtschiff_gro�)
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  z1_gro� = false
                  z2_gro� = false
                  z3_gro� = false
                  z4_gro� = false
                  u1_gro� = false
                  u2_gro� = false
                  u3_gro� = false
                  k1_gro� = false
                  k2_gro� = true
                  s_gro� = false
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  k2_gro� = false
                }
            }
            icon = kreuzer_icon
          }
          

          contents += kreuzer_2_gro�
          listenTo(kreuzer_2_gro�)
          schlachtschiff_gro� = new Button("Schlachtschiff") {
            background = java.awt.Color.WHITE
            preferredSize_=(new Dimension(350, 60))
            reactions += {
              case ButtonClicked(schlachtschiff_gro�) =>
                if (s_gro� == false) {
                  aktuelleLaenge = 5
                  reset(zerstoerer_1_gro�)
                  reset(zerstoerer_2_gro�)
                  reset(zerstoerer_3_gro�)
                  reset(zerstoerer_4_gro�)
                  reset(uboot_1_gro�)
                  reset(uboot_2_gro�)
                  reset(uboot_3_gro�)
                  reset(kreuzer_1_gro�)
                  reset(kreuzer_2_gro�)
                  
                  background_=(java.awt.Color.RED)
                  preferredSize_=(new Dimension(300, 60))
                  z1_gro� = false
                  z2_gro� = false
                  z3_gro� = false
                  z4_gro� = false
                  u1_gro� = false
                  u2_gro� = false
                  u3_gro� = false
                  k1_gro� = false
                  k2_gro� = false
                  s_gro� = true
                } else {
                  background = java.awt.Color.WHITE
                  preferredSize_=(new Dimension(350, 60))
                  s_gro� = false
                }
            }
            icon = schlachtschiff_icon
          }
          
          contents += schlachtschiff_gro�
          listenTo(schlachtschiff_gro�)
        }

        schiffleiste
    }
  }
 def reset(button: AbstractButton): Unit = {
   button.background_=(java.awt.Color.WHITE)
   button.preferredSize_=(new Dimension(350, 60))
 }
}