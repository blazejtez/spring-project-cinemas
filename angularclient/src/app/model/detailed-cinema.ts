export class DetailedCinema {

  name: string;
  street: string;
  city: string;
  zipCode: string;
  employeesNumber: number;
  phoneNumber: string;
  openingDate: string;

  constructor(name: string, street: string, city: string, zipCode: string, employeesNumber: number, phoneNumber: string, openingDate: string) {
    this.name = name;
    this.street = street;
    this.city = city;
    this.zipCode = zipCode;
    this.employeesNumber = employeesNumber;
    this.phoneNumber = phoneNumber;
    this.openingDate = openingDate;
  }
}
