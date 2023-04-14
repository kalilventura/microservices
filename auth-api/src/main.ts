import { Logger } from '@nestjs/common';
import { NestFactory } from '@nestjs/core';
import { AppModule } from './modules/app.module';
import { currentConfig } from './modules/global/configuration';
import { SwaggerModule, DocumentBuilder } from '@nestjs/swagger';

async function bootstrap() {
  Logger.log(
    `🚀 Application ${currentConfig.APP_NAME} running on PORT ${currentConfig.PORT} and on ENV: ${currentConfig.NODE_ENV}`,
  );
  const app = await NestFactory.create(AppModule);

  const config = new DocumentBuilder()
    .setTitle('Auth API')
    .setDescription('Auth API application')
    .setVersion('1.0.0')
    .addTag('users')
    .build();

  const document = SwaggerModule.createDocument(app, config);
  SwaggerModule.setup('api', app, document);
  await app.listen(currentConfig.PORT);
}
bootstrap();
