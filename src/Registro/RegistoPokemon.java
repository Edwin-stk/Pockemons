package Registro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistoPokemon {

	private JFrame frmPokemones;
	private JSpinner spnAtaque;
	private JSpinner spnDefensa;
	private JSpinner spnHP;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JScrollPane scrPokemon;
	private JTextField txtNombre;
	private JTextField txtTipo;
	private JTable tblPokemones;
	DefaultTableModel modelo =new DefaultTableModel();
	ArrayList<Pokemon> listaPokemones= new ArrayList<Pokemon>();
	Pokemon pokemon =new Pokemon();
	int index =-1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistoPokemon window = new RegistoPokemon();
					window.frmPokemones.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistoPokemon() {
		initialize();
	}

	public void actualizaTabla() {
		while(modelo.getRowCount()>0) modelo.removeRow(0);
		for (Pokemon po :listaPokemones){
		Object o[]= { po.getNombre(),po.getTipo(),po.getAtaque(),po.getDefensa(),po.getHp()};
		modelo.addRow(o);
	}
	tblPokemones.setModel(modelo);
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokemones = new JFrame();
		frmPokemones.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jose Alberto\\OneDrive\\Imágenes\\POKS.png"));
		frmPokemones.setTitle("POKEMONES");
		frmPokemones.setBounds(100, 100, 756, 348);
		frmPokemones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokemones.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(33, 38, 93, 21);
		frmPokemones.getContentPane().add(lblNombre);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(33, 87, 93, 21);
		frmPokemones.getContentPane().add(lblTipo);
		
		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAtaque.setBounds(33, 131, 93, 21);
		frmPokemones.getContentPane().add(lblAtaque);
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDefensa.setBounds(33, 177, 93, 21);
		frmPokemones.getContentPane().add(lblDefensa);
		
		JLabel lblHp = new JLabel("Punto de Salud");
		lblHp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHp.setBounds(33, 216, 114, 21);
		frmPokemones.getContentPane().add(lblHp);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon p=new Pokemon(
						txtNombre.getText(),
						txtTipo.getText(),
						Integer.parseInt(spnAtaque.getValue().toString()),
						Integer.parseInt(spnDefensa.getValue().toString()),
						Integer.parseInt(spnHP.getValue().toString()));
						listaPokemones.add(p);
						actualizaTabla();
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAgregar.setBounds(67, 264, 89, 23);
		frmPokemones.getContentPane().add(btnAgregar);

		
				
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion =JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar este Pkemon ??");
				if(opcion==0) {
					listaPokemones.remove(index);
					actualizaTabla();
				}
			}
			
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(187, 264, 89, 23);
		frmPokemones.getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnActualizar.setBounds(313, 264, 122, 23);
		frmPokemones.getContentPane().add(btnActualizar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(159, 39, 86, 20);
		frmPokemones.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(159, 88, 86, 20);
		frmPokemones.getContentPane().add(txtTipo);
		txtTipo.setColumns(10);
		
		spnAtaque = new JSpinner();
		spnAtaque.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		spnAtaque.setBounds(159, 132, 86, 20);
		frmPokemones.getContentPane().add(spnAtaque);

		
		
		spnDefensa = new JSpinner();
		spnDefensa.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		spnDefensa.setBounds(159, 178, 86, 20);
		frmPokemones.getContentPane().add(spnDefensa);
		
		spnHP = new JSpinner();
		spnHP.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		spnHP.setBounds(159, 217, 86, 20);
		frmPokemones.getContentPane().add(spnHP);
		
		scrPokemon = new JScrollPane();
		scrPokemon.setBounds(313, 11, 331, 226);
		frmPokemones.getContentPane().add(scrPokemon);
		
		
		tblPokemones = new JTable();
		tblPokemones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index=tblPokemones.getSelectedRow();
				pokemon=listaPokemones.get(tblPokemones.getSelectedRow());
				txtNombre.setText(pokemon.getNombre());
				txtTipo.setText(pokemon.getTipo());
				spnAtaque.setValue(pokemon.getAtaque());
				spnDefensa.setValue(pokemon.getDefensa());
				spnHP.setValue(pokemon.getHp());

			}
		});
		modelo.addColumn("NOMBRE");
		modelo.addColumn("TIPO");
		modelo.addColumn("ATAQUE");
		modelo.addColumn("DEFENSA");
		modelo.addColumn("HP");
		tblPokemones.setModel(modelo);
		scrPokemon.setViewportView(tblPokemones);
		
	}
}
