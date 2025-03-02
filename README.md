# Galaxy A20s GSI Fixes
This branch targets GSIs based on **TrebleDroid 15** and does the following:
* Fixes the fingerprint sensor.
* Fixes the swap partition.

The fingerprint fix requires LSPosed. Its source code can be found in the "[A20sFingerprintFix](./A20sFingerprintFix/)" folder.

## Installation
1. Download the module from the [releases page](https://github.com/GalaxyA20s/GSI-Fixes/releases)
2. Install it through  Magisk Manager
3. If not already installed, repeat both steps with LSPosed. Note that the official LSPosed doesn't support Android 15, so use [this fork]((https://github.com/JingMatrix/LSPosed/releases)).
4. Reboot
5. Open the LSPosed Manager, go to the Modules tab, press the "A20sFingerprintFix" module & enable it.
6. Reboot