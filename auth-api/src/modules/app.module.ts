import { Module } from '@nestjs/common';
import { UsersModule } from './users/user.module';
import { DatabaseModule } from './global/database/database.module';
import { AutomapperModule } from '@automapper/nestjs';
import { classes } from '@automapper/classes';

@Module({
  imports: [
    DatabaseModule,
    AutomapperModule.forRoot({ strategyInitializer: classes() }),
    UsersModule,
  ],
  controllers: [],
  providers: [],
})
export class AppModule {}
