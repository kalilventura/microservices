export class Token {
  constructor(accessToken: string) {
    this.accessToken = accessToken;
  }

  public readonly accessToken: string;
}
