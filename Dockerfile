# 1) Build stage: jar 만들기
FROM gradle:8.9-jdk17 AS build
WORKDIR /workspace
COPY . .
# gradlew가 있을 경우 실행 권한 보장
RUN chmod +x ./gradlew || true
RUN ./gradlew --no-daemon clean bootJar

# 2) Runtime stage: 가벼운 JRE로 실행
FROM eclipse-temurin:17-jre
WORKDIR /app
# 생성된 jar를 복사 (이름이 바뀌어도 *.jar로 커버)
COPY --from=build /workspace/build/libs/*.jar app.jar

EXPOSE 8080
# 필요시 메모리 옵션 등 환경변수로 전달 가능
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar"]