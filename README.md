# wealth-channel-service

# 代码发布方法
## 开始发布
> 必须在命令行下执行
> 必须在命令行下执行
> 必须在命令行下执行
```
mvn jgitflow:release-start -DreleaseVersion=1.0.10 -DdevelopmentVersion=1.0.11-SNAPSHOT -DpushReleases=true -DallowSnapshots=true
```
> -DreleaseVersion=1.0.6 -DdevelopmentVersion=1.0.7-SNAPSHOT
可以不输入，通过对话框输入也行.即:

```
mvn jgitflow:release-start  -DpushReleases=true -DallowSnapshots=true
```

## 发布结束
> 必须在命令行下执行
> 必须在命令行下执行
> 必须在命令行下执行

```
mvn jgitflow:release-finish -DnoReleaseBuild=true -DnoDeploy=true -DpushReleases=true