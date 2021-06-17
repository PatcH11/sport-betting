import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {Picture} from "../model/picture";

@Injectable({
  providedIn: 'root'
})
export class PictureService {

  constructor(private http: HttpClient) {
  }

  uploadPicture(file: File): Observable<HttpEvent<Picture>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `api/picture`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }
}
