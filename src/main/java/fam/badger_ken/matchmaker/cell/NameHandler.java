// c(2012) i.am.badger.ken@gmail.com
// You may re-use, so long as I am credited, and you don't charge
// for your work that uses this.
package fam.badger_ken.matchmaker.cell;

import java.awt.Component;
import java.util.Comparator;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import fam.badger_ken.matchmaker.Matchmaker;
import fam.badger_ken.matchmaker.Person;
import fam.badger_ken.matchmaker.widget.CopyableLabel;

public class NameHandler implements CellHandler {
  Matchmaker matchmaker;
  public NameHandler(Matchmaker matchmaker) {
    this.matchmaker = matchmaker;
  }

  @Override
  public int compare(Person arg0, Person arg1) {
    String name0 = arg0.getDisplayName(matchmaker.gameConfig, matchmaker.saveState);
    String name1 = arg1.getDisplayName(matchmaker.gameConfig, matchmaker.saveState);
    return name0.compareTo(name1);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    Person person = (Person) value;
    if (person == null) return null;
    String val = person.getDisplayName(matchmaker.gameConfig, matchmaker.saveState);
    return new JLabel(val);
  }

}
