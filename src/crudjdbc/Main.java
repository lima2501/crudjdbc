package crudjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException {

		Scanner scan = new Scanner(System.in);
		UserDAO dao = new UserDAO();

		System.out.println("Escolha uma opção abaixo:" + "\n[1] Cadastrar usuário" + "\n[2] Visualizar usuários"
				+ "\n[3] Procurar por id" + "\n[4] Atualizar um regtistro por id" + "\n[5] Deletar usuário por id");
		int op = scan.nextInt();
		scan.nextLine();

		switch (op) {
		case 1:
			System.out.print("Nome: ");
			String name = scan.nextLine();
			System.out.print("Email: ");
			String email = scan.nextLine();

			User user = new User(name, email);

			dao.create(user);
			break;
		case 2:

			List<User> users = new ArrayList<User>();
			ResultSet rs = dao.readAll();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				name = rs.getString("name");
				email = rs.getString("email");

				users.add(new User(id, name, email));

			}

			for (User u : users) {
				System.out.println(u);
				System.out.println("==========================");
			}
			break;
		case 3:
			System.out.print("Informe o id: ");
			int id = scan.nextInt();
			rs = dao.readById(id);
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				System.out.println(user);
				break;
			}
		case 4:
			System.out.print("Informe o id: ");
			id = scan.nextInt();
			scan.nextLine();
			System.out.print("Nome: ");
			name = scan.nextLine();
			System.out.print("Email: ");
			email = scan.nextLine();

			user = new User(name, email);
			dao.update(user, id);
			break;
		case 5:
			System.out.print("Informe o id: ");
			id = scan.nextInt();
			dao.delete(id);
			break;
		default:
			System.out.println("Opção inválida");
			dao.getConnection().close();
		}

		scan.close();
	}
}
