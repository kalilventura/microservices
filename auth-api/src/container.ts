import {
    asClass,
    createContainer,
    asFunction,
    InjectionMode,
    AwilixContainer,
    asValue
  } from 'awilix';
import {currentConfig} from "./config/configuration";
import {Server} from "./modules/server";
import {Router} from "./modules/global/router";
import { UserRouter } from './modules/users/infrastructure/router';
import { FindUserByEmailService } from './modules/users/infrastructure/services/find-user-by-email-service';
import { UserRepository } from './modules/users/infrastructure/repositories/user-repository';
import { FindUserByEmailCommand } from './modules/users/domain/commands/find-user-by-email-command';
import { UserController } from './modules/users/infrastructure/controllers';

export class Container {
    private readonly container: AwilixContainer;

    constructor() {
        this.container = createContainer({
        injectionMode: InjectionMode.CLASSIC
    });

    this.register();
  }

  public register(): void {
    this.container
    .register({
        // core
        server: asClass(Server).classic(),
        config: asValue(currentConfig),
        router: asFunction(Router).classic(),
    })
    .register({
        apiRouter: asFunction(UserRouter).classic()
    })
    .register({
      userRepository: asClass(UserRepository).classic(),
      getUserFindByEmailService: asClass(FindUserByEmailService).classic(),
      findUserByEmailCommand: asClass(FindUserByEmailCommand).classic(),
      findUserController: asClass(UserController).classic()
    })
    ;
  }

  public invoke(): AwilixContainer {
    return this.container;
  }
}
