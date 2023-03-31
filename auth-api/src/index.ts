import {Server} from "./modules/server";
import {Configuration} from "./config/configuration";
import {Container} from "./container";
import { initializeDatabase, seedInitialData } from "./config/db/seeds";

const container = new Container();
const server = container.invoke().resolve<Server>("server");
const config = container.invoke().resolve<Configuration>('config');

server
  .start()
  .then(async () => {
    console.info(`Environment: ${config.NODE_ENV}`);
    console.info(`Server started at port ${config.PORT}`);

    initializeDatabase();

    if (config.NODE_ENV === 'development') {
        seedInitialData();
    }

  })
  .catch((err: Error) => {
    console.error(err);
    process.exit(1);
  });
