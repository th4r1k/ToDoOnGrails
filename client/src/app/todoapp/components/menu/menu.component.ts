import { Component, OnInit, ViewChild } from '@angular/core';
import { ModalService } from '../../service'

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private modalService: ModalService) { }

  ngOnInit() {
  }

  showModal(){
  this.modalService.showModal()
  }

  hideModal(){
    this.modalService.hideModal()
    }

}
