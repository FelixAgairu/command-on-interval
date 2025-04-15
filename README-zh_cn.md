[English](/README.md) **[简体中文](README-zh_cn.md)**
## 这是什么
一款可执行游戏内命令的模组，外加自定义设置。\
目前，命令会在服务器模组初始化完成后执行。

## 使用
- 用户\
加载所需模组[Config Manager](https://modrinth.com/mod/config-manager).
- 开发者\
在**build.gradle**里:\
`modImplementation files('cfg-mgr-1.0.0.jar')`\
或\
`modImplementation "dev.felixagairu.configmanager:1.0.0"`

## 特点
- 多命令支持
- 刻或秒：使用游戏刻度或秒（20刻）作为时间计量单位
- 延迟：命令执行前延迟
- 周期: 命令执行周期
- ~为什么要在Java里执行游戏命令~

## 示例
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
> 第一条命令，可以添加"1"然后"2"以此类推

#### unit-use-ticks
> True使用刻，False使用秒

#### delay
> 每条命令执行前延迟

#### interval
> 每条命令执行循环周期

#### command
> 游戏内命令不需要**`/`**前缀
