import { Injectable } from '@angular/core';
import { RestConstants } from '../../shared/restapi/rest-constants';
import { HttpClient } from '@angular/common/http';
import { UploadFileDataRequest } from '../../models/files/upload-file-data-request';
import { Observable } from 'rxjs';
import { InfoFileResponse } from '../../models/files/info-file-response';

@Injectable({
  providedIn: 'root'
})
export class FilesService {

  restConstants = new RestConstants();

  constructor(private httpClient: HttpClient) { }

  uploadFile(dataToSend: UploadFileDataRequest): Observable<InfoFileResponse> {
    let formData: FormData = new FormData();
    formData.append('fileObject', dataToSend.fileObject, dataToSend.fileObject.name);
    formData.append('name', dataToSend.name);
    return this.httpClient.post<InfoFileResponse>(this.restConstants.API_URL + 'files', formData);
  }

  downloadFile(infoFile: InfoFileResponse): string {
    return this.restConstants.API_URL + 'files?pathFile=' + infoFile.filePath + '&fileName=' + infoFile.fileName;
  }

}
