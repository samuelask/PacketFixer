[![Hits](https://hits.sh/github.com/tonimatasdev/packetfixer.svg?view=today-total&label=Views)](https://hits.sh/github.com/tonimatasdev/packetfixer/)
# Packet Fixer
##### Visit my discord server: [Link](https://discord.com/invite/vWBP4P4Yd8)

## Description
This mod increases the packet sizes to prevent various package erros. This mod could be used in mod packs for increasing the number of mods.

### Prevent these problems:
 - Tried to read NBT tag that was too big; tried to allocate: X bytes where max allowed: 2097152
 - Badly compressed packet - size of X is larger than protocol maximum of 2097152
 - Attempted to send packet over maximum protocol size: 8388608
 - Chunk Packet trying to allocate too much memory on read.
 - Packet too big (is X, should be less than 8388608)
 - Payload may not be larger than 1048576 bytes
 - Payload may not be larger than 32767 bytes
 - Packet too large: size X is over 8
 - Length wider than 21-bit
 - Unable to fit X into 3
 - Connection timeout
 - VarLong too big
 - VarInt too big

### Fix these problems:
 - Unable to fit X into 3 **[Delete Krypton and Pluto in both sides]**
 - VarInt too long **[Try deleting Krypton and Pluto in both sides]**

###  Feel free to use this mod on your modpack
