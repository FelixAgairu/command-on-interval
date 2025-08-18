**[English](/README.md)** [简体中文](https://github.com/FelixAgairu/command-on-interval/blob/main/README-zh_cn.md)
## What is that
A mod runs in-game command with customize configs.\
For now the commands will run as soon as server mod initialize.

## Use
Also load the require mod [Config Manager](https://modrinth.com/mod/config-manager)\
Remember that Singleplayer contains an integrated server.

## Features
- Multi-command support
- Ticks or seconds: Whether use game ticks or seconds (20 ticks) in timing
- Delays: Add delay before command run
- Interval: The cycle of each command does
- ~~There's no reason to run a command from Java code~~

## Example
![eg](https://cdn.modrinth.com/data/cached_images/50dbf240015376229c8493ce18401910cf1004d1_0.webp)
`command_on_interval.json`:
```json
{
   "0":{
      "enabled":true,
      "unit-use-ticks":false,
      "delay":0,
      "interval":10,
      "command":"say Hello, world!"
   },
   "1":{
      "enabled":true,
      "unit-use-ticks":true,
      "delay":0,
      "interval":180,
      "command":"time set day"
   },
   "2":{
      "enabled":true,
      "unit-use-ticks":true,
      "delay":5,
      "interval":200,
      "command":"kill @e[type=item]"
   }
}
```

## Config
Locate your config in Minecraft installation location.\
> Default location using official launcher on Windows:\
> `%APPDATA%\.minecraft\config\command_on_interval.json`\
> Or\
> `C:\Users\YOUR_USER_NAME\AppData\Roaming\.minecraft\config\command_on_interval.json`

You will get somethings like that:
```json
{
   "0":{
      "enabled":true,
      "unit-use-ticks":false,
      "delay":0,
      "interval":10,
      "command":""
   }
}
```

#### "0"
> No. 1 command，you can add `"1"` also `"2"` etc...

#### enabled
> True enable this entry of setting, vice versa

#### unit-use-ticks
> For delay or interval, `true` use ticks, `false` ues seconds

#### delay
> Delay before each command runs

#### interval
> Cycles interval for each command

#### command
> In-game command without **`/`** prefix\
> Eg. `time set day`

[icon.png](https://github.com/FelixAgairu/command-on-interval/blob/a84597bd1226937d9cecaf0b035119eac5612c4a/src/main/resources/assets/command-on-interval/icon.png) © 2025 by [FelixAgairu](https://github.com/FelixAgairu) is licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
