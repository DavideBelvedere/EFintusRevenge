export class Navbar{
    id: number;
    name: string;
    dropdowns: Navbar[];
    
    public constructor(id: number, name: string, dropdowns: Navbar[]){
        this.id = id;
        this.name = name;
        this.dropdowns = dropdowns;
    }
    
}