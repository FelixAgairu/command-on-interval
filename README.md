**[English](/README.md)** [简体中文](README-zh_cn.md)
## What is that
A mod runs in-game command with customize configs.\
For now the commands will run as soon as server mod initialize.

## Use
- Users\
Also load the require mod [Config Manager](https://modrinth.com/mod/config-manager)\
Remember that Singleplayer contains an integrated server.
- Developer\
See [Github](https://github.com/FelixAgairu/command-on-interval)

## Features
- Multi-command support
- Ticks or seconds: Whether use game ticks or seconds (20 ticks) in timing
- Delays: Add delay before command run
- Interval: The cycle of each command does
- ~There's no reason to run a command from java~

## Example
`command_on_interval.json`:
```json
{
   "0":{
      "unit-use-ticks":false,
      "delay":0,
      "interval":10,
      "command":"say Hello, world!"
   },
   "1":{
      "unit-use-ticks":true,
      "delay":0,
      "interval":180,
      "command":"time set day"
   },
   "2":{
      "unit-use-ticks":true,
      "delay":5,
      "interval":200,
      "command":"kill @e[type=item]"
   }
}
```

## Config
Locate your config in Minecraft installation location:\
`%APPDATA%\.minecraft\config\command_on_interval.json` on Windows, default location.\
You will get somethings like that:
```json
{
   "0":{
      "unit-use-ticks":false,
      "delay":0,
      "interval":10,
      "command":""
   }
}
```

#### "0"
> No. 1 command，you can add "1" also "2" etc...

#### unit-use-ticks
> True use ticks, False ues seconds

#### delay
> Delay before each command runs

#### interval
> Cycles interval for each command

#### command
> In-game command without `/` prefix:\
> Eg. `time set day`
