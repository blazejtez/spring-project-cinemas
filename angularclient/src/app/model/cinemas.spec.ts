import { Cinemas } from './cinemas';
import {Cinema} from "./cinema";

describe('Cinemas', () => {
  it('should create an instance', () => {
    expect(new Cinemas([])).toBeTruthy();
  });
});
