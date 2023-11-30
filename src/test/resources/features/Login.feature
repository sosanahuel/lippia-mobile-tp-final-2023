Feature: Como usuario deseo probar las diferentes funcionalidad para loguearme

  Scenario Outline: El usuario logra loguearse correctamente
    Given el usuario ingreso a la app correctamente
    When el usuario ingresa su <email>, <password>
    Then el usuario se a logeado correctamente con su <email>

    Examples:
      | email             | password  |
      | xnahuex@gmail.com | Asdasd123 |