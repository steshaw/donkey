#!/bin/sh

if [ $# -ne 1 ]; then
    echo "usage: $0 payload-class-name" >&2
    exit 2
fi

SCRIPT_DIR=`pwd`
PAYLOAD_CLASSNAME=$1
CONFIG_DIR=$SCRIPT_DIR/config
LIB_DIR=$SCRIPT_DIR/lib

JAVA_CMD=$JAVA_HOME/bin/java
if [ -z "$JAVA_CMD" ]; then
    echo
    echo Error: Could not find the Java executable '$JAVA_CMD'.
    echo
    exit 1
fi

CLASSPATH=donkey.jar
for i in `find ./lib -name "*.jar"`; do
    CLASSPATH=$CLASSPATH:$i
done

JVM_OPTIONS="-Xmx256m"
#JVM_DEBUG_OPTIONS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5010"

EXEC="$JAVA_CMD $JVM_OPTIONS $JVM_DEBUG_OPTIONS -Dlog4j.configuration=file:$CONFIG_DIR/log4j/log4j.properties \
    -cp $CLASSPATH org.burroloco.donkey.trebuchet.Main $PAYLOAD_CLASSNAME"
echo "$EXEC"
exec $EXEC