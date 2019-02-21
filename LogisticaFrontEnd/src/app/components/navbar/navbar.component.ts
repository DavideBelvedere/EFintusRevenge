import { Component, OnInit } from '@angular/core';
import { Navbar } from 'src/app/beans/utility/navbar';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  menu: Navbar[] = [];
  voice: Navbar;

  constructor() {
    this.init();
    console.log(this.menu);
  }

  ngOnInit() {
  }

  init(){
    this.voice = new Navbar(0,"Home",[new Navbar(1,"HomeSub",[])]);
    this.menu.push(this.voice);

  }

}
