Feature: Datatable Ornek

  Scenario: Users List
    When write username "Gökhan"
    And write username and password "ismet" and "1234"

    And write username as DataTable
      | Gökhan |
      | ismet  |
      | ayşe   |
      | fatma  |
      | ulvi   |
      | esma   |
    And write username and password as DataTable
      | Gökhan | 1234 |
      | ismet  | 3452 |
      | ayşe   | 3423 |
      | fatma  | 4564 |
      | ulvi   | 3423 |
      | esma   | 3453 |
     # dataProvider (TestNG için), Senaryo Outline (cucumber)
 #  görevi verilen her değer için, tüm senayo çalışır
 #
 #  DataTable ise , sadece bir step e, çoklu parametre vermek
 #  için kullanılır
