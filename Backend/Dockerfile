# 指定基础镜像
FROM ubuntu:latest
# 环境变量 JDK安装目录
ENV JAVA_DIR=/usr/local

# 拷贝JDK和jar包
COPY ./jdk-21_linux-x64_bin.tar.gz $JAVA_DIR/
COPY ./Schedule-0.0.1-SNAPSHOT.jar /tmp/app.jar

# 安装JDK
RUN cd $JAVA_DIR \
 && tar -xf ./jdk-21_linux-x64_bin.tar.gz \
 && ./jdk-21.0.4 ./java21
 
# 配置环境变量
ENV JAVA_HOME=$JAVA_DIR/java21
ENV PATH=$PATH:$JAVA_HOME/bin

# 暴露端口
EXPOSE 8080
#ENTRYPOINT java -jar /tmp/app.jar &
CMD ["java", "-jar", "-Dspring.profiles.active=prod", "/tmp/app.jar", "&"]