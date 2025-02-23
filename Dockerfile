# 使用最新的 Maven 和 JDK 17 镜像
FROM maven:3.8-openjdk-17 as builder

# 设置工作目录
WORKDIR /app

# 复制本地项目文件到容器中
COPY pom.xml .
COPY src ./src

# 构建项目并跳过测试
RUN mvn package -DskipTests

# 设置容器启动时运行的命令
CMD ["java", "-jar", "/app/target/user-center-backend-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]