import {Picture} from "./picture";

export interface User {
  id: number;
  picture: Picture;
  username: string;
  password: string;
  email: string;
  firstName: string;
  lastName: string;
}

export interface UserCreate {
  pictureId: number;
  username: string;
  password: string;
  email: string;
  firstName: string;
  lastName: string;
}

export interface AuthUser {
  username: string;
  password: string;
}
