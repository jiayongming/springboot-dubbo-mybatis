#!/bin/sh

curdir=`dirname $0`
cd $curdir
curdir=`pwd`

APP_NAME=`ls  ../lib/springboot-dubbo-mybatis-*.jar | grep -o "springboot.*jar" | tr -d '\r'`

PLATFORM=Dplatform=default

if [ $# -gt 0 ];then
   PLATFORM=Dplatform=$1
fi

if [ -z "$APP_NAME" ]; then
    echo "ERROR: The $APP_NAME does not started!"
    exit 1
fi

PIDS=`ps aux | fgrep "$APP_NAME" | fgrep "$PLATFORM" | fgrep -v "fgrep" | awk '{print $2}'`

if [ -z "$PIDS" ]; then
    echo "ERROR: The $APP_NAME $PLATFORM does not started!"
    exit 1
fi


echo -e "Stopping the $APP_NAME $PLATFORM ...\c"
for PID in $PIDS ; do
    kill $PID > /dev/null 2>&1
done

COUNT=0
while [ $COUNT -lt 1 ]; do    
    echo -e ".\c"
    sleep 1
    COUNT=1
    for PID in $PIDS ; do
        PID_EXIST=`ps -f -p $PID | grep java`
        if [ -n "$PID_EXIST" ]; then
            COUNT=0
            break
        fi
    done
done

echo "OK!"
echo "PID: $PIDS"
