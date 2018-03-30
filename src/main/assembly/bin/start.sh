#!/bin/sh
curdir=`dirname $0`
cd $curdir
curdir=`pwd`
#JAVA_HOME=/usr/local/jdk1.7.0_80/bin
APP_NAME=`ls  ../lib/springboot-dubbo-mybatis-*.jar | grep -o "springboot.*jar" | tr -d '\r'`
echo $APP_NAME
MAIN_CLASS=com.ymjia.demo.application.server.Server
APP_HOME=..
LIB_PATH=$APP_HOME/lib

CLASSPATH=$APP_HOME:$LIB_PATH/$APP_NAME:$APP_HOME/resources

JAVA_ARGS="-server -Xmx1024m -Xmx1024m -XX:NewSize=256m -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=78 -Xloggc:$APP_HOME/logs/gc.log"

PLATFORM=-Dplatform=default

if [ $# -gt 0 ];then
   PLATFORM=-Dplatform=$1
fi

cd $APP_HOME/bin

echo "$CLASSPATH"

echo java $JAVA_ARGS -classpath $CLASSPATH $MAIN_CLASS

echo " java  $PLATFORM $JAVA_ARGS  -classpath $CLASSPATH $MAIN_CLASS  1> /dev/null 2>&1 "
nohup java $PLATFORM $JAVA_ARGS  -classpath $CLASSPATH $MAIN_CLASS  1> /dev/null 2>&1 &


#java -classpath $CLASSPATH $MAIN_CLASS
