// c(2012) i.am.badger.ken@gmail.com
// You may re-use, so long as I am credited, and you don't charge
// for your work that uses this.
package fam.badger_ken.matchmaker.cell;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;

import fam.badger_ken.matchmaker.Matchmaker;
import fam.badger_ken.matchmaker.Person;

public class AttributeHandler implements CellHandler {
  private final int ordinality;

  final Matchmaker matchmaker;
  public AttributeHandler(Matchmaker matchmaker, int ordinality) {
    this.matchmaker = matchmaker;
    this.ordinality = ordinality;
  }

  @Override
  public int compare(Person arg0, Person arg1) {
    Integer stat0 = arg0.getAdjustedAttribute(matchmaker.gameConfig, ordinality);
    Integer stat1 = arg1.getAdjustedAttribute(matchmaker.gameConfig, ordinality);
    return stat0.compareTo(stat1);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    Person person = (Person) value;
    if (person == null) return null;
    JLabel label = new JLabel(person.getAdjustedAttribute(matchmaker.gameConfig, ordinality).toString());
    label.setHorizontalAlignment(JLabel.RIGHT);
    return label;
  }

}
