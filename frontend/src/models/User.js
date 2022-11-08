import { AccessLevel } from "./AccessLevel";

export class User{

    id = Number;
    cpf = String;
    password = String;
    AccessLevel = AccessLevel;
    logged = Boolean;
    
}