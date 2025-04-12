## What is that
A mod runs in-game command with customize configs.\
For now the commands will run as soon as server mod initialize.

## 这是什么
一款可执行游戏内命令的模组，外加自定义设置。\
目前，命令会在服务器模组初始化完成后执行。

## Features
- Multi-command support
- Ticks or seconds: Whether use game ticks or seconds (20 ticks) in timing
- Delays: Add delay before command run
- Interval: The cycle of each command does
- ~There's no reason to run a command from java~

## 特点
- 多命令支持
- 刻或秒：使用游戏刻度或秒（20刻）作为时间计量单位
- 延迟：命令执行前延迟
- 周期: 命令执行周期
- ~为什么要在Java里执行游戏命令~

## Example 示例
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
## 自定义设置
在我的世界安装位置里找到配置文件：\
`%APPDATA%\.minecraft\config\command_on_interval.json` Windows默认位置\
文件会包括以下内容:
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
> No. 1 command，you can add "1" also "2" etc...\
> 第一条命令，可以添加"1"然后"2"以此类推

#### unit-use-ticks
> True use ticks, False ues seconds\
> True使用刻，False使用秒

#### delay
> Delay before each command runs\
> 每条命令执行前延迟

#### interval
> Cycles interval for each command\
> 每条命令执行循环周期

#### command
> In-game command without **`/`** prefix\
> 游戏内命令不需要**`/`**前缀
