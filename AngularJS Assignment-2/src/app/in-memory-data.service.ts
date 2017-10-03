import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Product } from './model/product'

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const PRODUCTS: Product[] = [
      { id: 101, name: "Television", price: 10999, img: "//n4.sdlcdn.com/imgs/f/b/2/SDL552042411-0cbda.jpg" },
      { id: 102, name: "Smartphone", price: 11999, img: "//n1.sdlcdn.com/imgs/e/a/x/LeEco-Le2-X526-32GB-Grey-SDL199586080-4-dbd42.jpg" },
      { id: 103, name: "Laptop", price: 40599, img: "//n1.sdlcdn.com/imgs/a/7/i/Namo-Art-Headphone-Laptop-Beats-SDL202722548-1-59ac8.jpg" },
      { id: 104, name: "Smartwatch", price: 2500, img: "//n3.sdlcdn.com/imgs/d/l/q/Life-Like-GT08-Bluetooth-Smartwatch-SDL218791842-1-8a103.jpg" },
      { id: 105, name: "Headphones", price: 3000, img: "//n2.sdlcdn.com/imgs/b/3/u/SLBTHP1-fb3ea.JPG" },
      { id: 106, name: "Trimmer", price: 999, img: "//n1.sdlcdn.com/imgs/f/3/4/Philips-Philips-BT1210-15-Trimmer-SDL286694951-2-58a5e.jpg" },
      { id: 107, name: "Monitors", price: 10999, img: "//n4.sdlcdn.com/imgs/f/8/t/LG-32MN58H-81-cm-32-SDL705448925-3-30fb8.jpg" },
      { id: 108, name: "Printer", price: 11000, img: "//n3.sdlcdn.com/imgs/a/l/o/Hp-Laserjet-M-1005-Multifunction-1601548-1-ebee5.jpg" },
      { id: 109, name: "SD Card", price: 299, img: "//n3.sdlcdn.com/imgs/c/2/k/SanDisk-Ultra-32-GB-Micro-SDL128364209-1-3031c.jpg" },
      { id: 110, name: "Speakers", price: 10000, img: "//n2.sdlcdn.com/imgs/e/h/j/1-83d79.jpg" },
      { id: 111, name: "VR Box", price: 9999, img: "//n1.sdlcdn.com/imgs/e/z/w/TUB-VR-BOX-2-0-SDL715668258-1-c4ffa.jpg//n1.sdlcdn.com/imgs/f/3/4/Philips-Philips-BT1210-15-Trimmer-SDL286694951-2-58a5e.jpg" },
      { id: 112, name: "Earphones", price: 599, img: "//n3.sdlcdn.com/imgs/c/g/b/Signature-VM-48-In-Ear-SDL330604218-1-f37b5.jpg" }
  ];
    return {PRODUCTS};
  }
}
