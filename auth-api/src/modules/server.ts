import express from "express";
import * as http from "http";
import {Configuration} from "../config/configuration";

export class Server {
    private readonly express: express.Express;
    private http: http.Server | any;

    constructor(
        private router: express.Router,
        private config: Configuration) {
        this.express = express();
        this.express.use(this.router);
    }

    public start = async (): Promise<void> => {
        return await new Promise<void>((resolve) => {
            this.http = this.express.listen(this.config.PORT, () => {
                const { port } = this.http.address();
                console.info(`🚀 Application ${this.config.APP_NAME} running on PORT ${port}`);
                resolve();
              });
        });
    }

    public stop = async (): Promise<void> => {
        console.info('Stopping http server...');
        await this.http.close();
    };

    public invoke = (): express.Application => this.express;
}
