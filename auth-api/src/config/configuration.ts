import * as dotenv from 'dotenv';

dotenv.config();

export type Configuration = {
    NODE_ENV: string;
    PORT: number;
    APP_NAME: string;
    DATABASE: string;
    USERNAME: string;
    PASSWORD: string;
    HOST: string;
};

export const currentConfig: Configuration = {
    NODE_ENV: 'development',
    PORT: +(process.env.PORT || 3000),
    APP_NAME: process.env.APP_NAME || 'express-ts-ddd',
    DATABASE: process.env.DATABASE || "auth-db",
    USERNAME: process.env.USERNAME || "admin",
    PASSWORD: process.env.PASSWORD || "123456",
    HOST: process.env.HOST || "localhost",
};

