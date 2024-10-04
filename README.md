# Fadeless
**This is a forked version of [No Fade](https://github.com/UltimateBoomer/mc-no-fade) for 1.20 and up.**


Are you annoyed with the long transition animation when you load into Minecraft? Fadeless is a client side mod that removes all of those fade out animations in Minecraft. This includes the fade out from the Mojang splash screen to the main menu, and the fade out after reloading textures.
## **Whats new compared to the original?**
- 1.20 support and beyond.
- Reduced File size by using a more optimized icon. (16kb to ~8kb)
- Removed Fabric API dependency as it’s not needed.
- Removes Fabric Loader as a dependency for better quilt compatibility.
- Forge and NeoForge support!
  ![](https://raw.githubusercontent.com/UltimateBoomer/mc-no-fade/assets/images/demo.gif)
## This is a fork of [no fade](https://github.com/UltimateBoomer/mc-no-fade). The author has [given me permission](https://raw.githubusercontent.com/DerpDerpling/i.derpy.xyz/main/img/proof.png) to reupload/maintain this. All credit goes to [UltimateBoomer.](https://github.com/UltimateBoomer)
## Setup
Run `./gradlew validateAccessWidener` first to generate the access wideners. You will have to do this every time you modify the access widener.

## Build
Run `./gradlew build`, or let GitHub Actions do it for you.