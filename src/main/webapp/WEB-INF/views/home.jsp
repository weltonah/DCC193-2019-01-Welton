<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://unpkg.com/ionicons@4.5.5/dist/ionicons.js"></script>
</head>
<body style="background-color: #f2f2f2;">

<div class="row">
    <c:import url="cabecalho.jsp" />
</div>
<div class="container mt-4 shadow p-3 mb-5 bg-white rounded" style="background-color:white; ">
    <div class="row">
        <div class="col-12">
            <div class="row justify-content-md-center">
                <div class="col-md-auto">
                    <h3 > Lista de Sedes</h3>
                </div>
            </div>
        </div>
        <div class="col-12">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#cadastroModal">
                <ion-icon name="add"></ion-icon>Cadastrar
            </button>
        </div>
        <div class="col-12 mt-4">

            <table class="table table-striped">
                <thead class="thead-light">
                <tr>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col">Nome Fantasia</th>
                    <th scope="col">UF</th>
                    <th scope="col">Cidade</th>
                    <th scope="col">Bairro</th>
                    <th scope="col">Telefone</th>
                    <th scope="col">Endereço Web</th>
                    <th scope="col">Horas de Atividade</th>
                    <th scope="col">Menbros</th>
                    <th scope="col">Atividades</th>
                </tr>
                </thead>
                <tbody style="font-size: 15px;">
                <c:forEach items="${listaSede}" var="item" varStatus="status">
                    <tr>
                        <th scope="row">
                            <a href="DeleteSede?id=${item.getId()}" class="btn btn-outline-danger btn-sm" role="button">
                                <div class="col-6"><ion-icon name="close"></ion-icon></div>
                            </a>
                        </th>
                        <th>
                            <button type="button" class="btn btn-outline-warning btn-sm" data-toggle="modal"
                                    data-target="#AlterarModal${item.getId()}">
                                <div class="col-6"><ion-icon name="create"></ion-icon></div>
                            </button>
                        </th>
                        <th>${item.getNome()}</th>
                        <th>${item.getUF()}</th>
                        <th>${item.getCidade()}</th>
                        <th>${item.getBairro()}</th>
                        <th>${item.getTelefone()}</th>
                        <th>${item.getEnderecoWeb()}</th>
                        <th>${item.getHorasTotais()}</th>
                        <th scope="row">
                            <a href="GetMenbro?idSede=${item.getId()}" class="btn btn-primary" role="button">Menbros</a>
                        </th>
                        <th scope="row">
                            <a href="GetAtividade?idSede=${item.getId()}" class="btn btn-primary" role="button">Atividades</a>
                        </th>
                    </tr>
                    <div class="modal fade" id="AlterarModal${item.getId()}" tabindex="-1" role="dialog"
                         aria-labelledby="AlterarModal${item.getId()}Label"
                         aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="AlterarModal${item.getId()}Label">Editar de Sede</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action="UpdateSede?idSede=${item.getId()}" method="post">
                                    <div class="modal-body">
                                        <div class="form-group ">
                                            <label for="AlterarnameFantasia">Nome Fantasia</label>
                                            <input type="text" class="form-control form-control-sm"
                                                   id="AlterarnameFantasia"
                                                   value="${item.getNome()}"
                                                   name="nome" aria-describedby="emailHelp" placeholder="nome Fantasia">
                                        </div>
                                        <div class="form-group ">
                                            <label for="AlterarFormControlSelect1">UF</label>
                                            <select class="form-control form-control-sm" name="UF"
                                                    id="AlterarFormControlSelect1">
                                                <option value="${item.getUF()}">${item.getUF()}</option>
                                                <option value="AC">AC</option>
                                                <option value="AL">AL</option>
                                                <option value="AM">AM</option>
                                                <option value="AP">AP</option>
                                                <option value="BA">BA</option>
                                                <option value="CE">CE</option>
                                                <option value="DF">DF</option>
                                                <option value="ES">ES</option>
                                                <option value="GO">GO</option>
                                                <option value="MA">MA</option>
                                                <option value="MG">MG</option>
                                                <option value="MS">MS</option>
                                                <option value="MT">MT</option>
                                                <option value="PA">PA</option>
                                                <option value="PB">PB</option>
                                                <option value="PE">PE</option>
                                                <option value="PI">PI</option>
                                                <option value="PR">PR</option>
                                                <option value="RJ">RJ</option>
                                                <option value="RN">RN</option>
                                                <option value="RS">RS</option>
                                                <option value="RO">RO</option>
                                                <option value="RR">RR</option>
                                                <option value="SC">SC</option>
                                                <option value="SE">SE</option>
                                                <option value="SP">SP</option>
                                                <option value="TO">TO</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="Alterarcidade">Cidade</label>
                                            <input type="text" value="${item.getCidade()}"
                                                   class="form-control form-control-sm" id="Alterarcidade"
                                                   name="cidade" aria-describedby="emailHelp" placeholder="cidade"
                                                   required>
                                        </div>
                                        <div class="form-group">
                                            <label for="Alterarbairro">Cidade</label>
                                            <input type="text" value="${item.getBairro()}"
                                                   class="form-control form-control-sm" id="Alterarbairro"
                                                   name="bairro" aria-describedby="emailHelp" placeholder="bairro"
                                                   required>
                                        </div>
                                        <div class="form-group">
                                            <label for="Alterartelefone">Telefone</label>
                                            <input type="text" value="${item.getTelefone()}"
                                                   class="form-control form-control-sm" id="Alterartelefone"
                                                   name="telefone" aria-describedby="emailHelp" placeholder="telefone"
                                                   required>
                                        </div>
                                        <div class="form-group">
                                            <label for="AlterarWeb">Endereço Web</label>
                                            <input type="text" value="${item.getEnderecoWeb()}"
                                                   class="form-control form-control-sm" id="AlterarWeb"
                                                   name="enderecoWeb" aria-describedby="emailHelp"
                                                   placeholder="endereço web" required>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar
                                        </button>
                                        <button type="submit" class="btn btn-primary">Atualizar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Button trigger modal -->


    <!-- Modal -->
    <div class="modal fade" id="cadastroModal" tabindex="-1" role="dialog" aria-labelledby="cadastroModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="cadastroModalLabel">Cadastro de Sede</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <form action="PostSede" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="examplenameFantasia">Nome Fantasia</label>
                            <input type="text" class="form-control form-control-sm" id="examplenameFantasia"
                                   name="nome" aria-describedby="emailHelp" placeholder="nome Fantasia" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">UF</label>
                            <select class="form-control form-control-sm" name="UF" id="exampleFormControlSelect1">
                                <option value="">Selecione</option>
                                <option value="AC">AC</option>
                                <option value="AL">AL</option>
                                <option value="AM">AM</option>
                                <option value="AP">AP</option>
                                <option value="BA">BA</option>
                                <option value="CE">CE</option>
                                <option value="DF">DF</option>
                                <option value="ES">ES</option>
                                <option value="GO">GO</option>
                                <option value="MA">MA</option>
                                <option value="MG">MG</option>
                                <option value="MS">MS</option>
                                <option value="MT">MT</option>
                                <option value="PA">PA</option>
                                <option value="PB">PB</option>
                                <option value="PE">PE</option>
                                <option value="PI">PI</option>
                                <option value="PR">PR</option>
                                <option value="RJ">RJ</option>
                                <option value="RN">RN</option>
                                <option value="RS">RS</option>
                                <option value="RO">RO</option>
                                <option value="RR">RR</option>
                                <option value="SC">SC</option>
                                <option value="SE">SE</option>
                                <option value="SP">SP</option>
                                <option value="TO">TO</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="examplecidade">Cidade</label>
                            <input type="text" class="form-control form-control-sm" id="examplecidade"
                                   name="cidade" aria-describedby="emailHelp" placeholder="cidade" required>
                        </div>
                        <div class="form-group">
                            <label for="examplebairro">Bairro</label>
                            <input type="text" class="form-control form-control-sm" id="examplebairro"
                                   name="bairro" aria-describedby="emailHelp" placeholder="bairro" required>
                        </div>
                        <div class="form-group">
                            <label for="exampletelefone">Telefone</label>
                            <input type="text" class="form-control form-control-sm" id="exampletelefone"
                                   name="telefone" aria-describedby="emailHelp" placeholder="telefone" required>
                        </div>
                        <div class="form-group">
                            <label for="exampletelefone">Endereço Web</label>
                            <input type="text" class="form-control form-control-sm" id="exampleWeb"
                                   name="enderecoWeb" aria-describedby="emailHelp" placeholder="endereço web" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</html>