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
    NODE_ENV: process.env.NODE_ENV!,
    PORT: +(process.env.PORT!),
    APP_NAME: process.env.APP_NAME!,
    DATABASE: process.env.DATABASE!,
    USERNAME: process.env.USERNAME!,
    PASSWORD: process.env.PASSWORD!,
    HOST: process.env.HOST!,
};

