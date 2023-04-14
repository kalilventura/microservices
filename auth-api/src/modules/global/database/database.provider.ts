import { Sequelize } from 'sequelize-typescript';
import { SequelizeUser } from '../../users/infrastructure/repositories/models/user.model';
import { currentConfig } from '../configuration';

export const databaseProviders = [
  {
    provide: 'SEQUELIZE',
    useFactory: async () => {
      const sequelize = new Sequelize({
        dialect: 'postgres',
        host: currentConfig.DB_HOST,
        port: currentConfig.DB_PORT,
        username: currentConfig.USERNAME,
        password: currentConfig.PASSWORD,
        database: currentConfig.DATABASE,
        quoteIdentifiers: false,
        define: {
          timestamps: false,
          underscored: true,
          freezeTableName: true,
        },
      });
      sequelize.addModels([SequelizeUser]);
      await sequelize.sync();
      return sequelize;
    },
  },
];
