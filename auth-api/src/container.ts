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
        server: asClass(Server).singleton(),
        config: asValue(currentConfig),
        router: asFunction(Router).singleton(),
    })
    .register({
        apiRouter: asFunction(UserRouter).singleton()
    })
    .register({
      getUserFindByEmailService: asClass(FindUserByEmailService).scoped()
    })
    .register({
      userRepository: asClass(UserRepository).scoped()
    })
    ;
  }

  public invoke(): AwilixContainer {
    return this.container;
  }
}
