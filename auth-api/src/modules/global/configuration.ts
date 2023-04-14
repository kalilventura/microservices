import * as dotenv from 'dotenv';

dotenv.config();

export type Configuration = {
  NODE_ENV: string;
  PORT: number;
  APP_NAME: string;
  DATABASE: string;
  USERNAME: string;
  PASSWORD: string;
  DB_HOST: string;
  DB_PORT: number;
};

export const currentConfig: Configuration = {
  NODE_ENV: process.env.NODE_ENV!,
  PORT: +process.env.PORT!,
  APP_NAME: process.env.APP_NAME!,
  DATABASE: process.env.DATABASE!,
  USERNAME: process.env.USERNAME!,
  PASSWORD: process.env.PASSWORD!,
  DB_HOST: process.env.HOST!,
  DB_PORT: +process.env.DB_PORT!,
};
