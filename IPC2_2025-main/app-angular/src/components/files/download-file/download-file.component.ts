import { Component, Input } from '@angular/core';
import { InfoFileResponse } from '../../../models/files/info-file-response';
import { FilesService } from '../../../services/files/files.service';

@Component({
  selector: 'app-download-file',
  imports: [],
  templateUrl: './download-file.component.html',
  styleUrl: './download-file.component.css',
})
export class DownloadFileComponent {

  @Input()
  infoFile!: InfoFileResponse;

  constructor(private filesService: FilesService) {
  }

  getDownloadFileURL(): string {
    return this.filesService.downloadFile(this.infoFile);
  }

 }
