// c(2012) i.am.badger.ken@gmail.com
// You may re-use, so long as I am credited, and you don't charge
// for your work that uses this.
package fam.badger_ken.matchmaker.cell;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;

import fam.badger_ken.matchmaker.Matchmaker;
import fam.badger_ken.matchmaker.Person;

public class CultureHandler implements CellHandler {
  final Matchmaker matchmaker;
  public CultureHandler(Matchmaker matchmaker) {
    this.matchmaker = matchmaker;
  }

  @Override
  public int compare(Person arg0, Person arg1) {
    String name0 = arg0.getDisplayCulture(matchmaker.gameConfig);
    String name1 = arg1.getDisplayCulture(matchmaker.gameConfig);
    return name0.compareTo(name1);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    Person person = (Person) value;
    if (person == null) return null;
    String val = person.getDisplayCulture(matchmaker.gameConfig);
    return new JLabel(val);
  }

}
