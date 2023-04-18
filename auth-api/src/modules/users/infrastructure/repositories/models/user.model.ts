import { Optional } from 'sequelize';
import {
  Table,
  Model,
  Column,
  DataType,
  PrimaryKey,
  AutoIncrement,
  CreatedAt,
  UpdatedAt,
} from 'sequelize-typescript';

interface UserAttributes {
  id: number;
  name: string;
  email: string;
  password: string;
  creationDate: Date;
  updatedOn: Date;
}

// eslint-disable-next-line @typescript-eslint/no-empty-interface
export interface SequelizeUserAttributes
  extends Optional<UserAttributes, 'id'> {}

@Table({ tableName: 'user' })
export class SequelizeUser extends Model<
  UserAttributes,
  SequelizeUserAttributes
> {
  @PrimaryKey
  @AutoIncrement
  @Column({ type: DataType.BIGINT })
  public id: number;

  @Column({ type: DataType.STRING, allowNull: false })
  public name: string;

  @Column({ type: DataType.STRING, allowNull: false })
  public email: string;

  @Column({ type: DataType.STRING, allowNull: false })
  public password: string;

  @CreatedAt
  creationDate: Date;

  @UpdatedAt
  updatedOn: Date;
}
