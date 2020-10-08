# SPED-BACKEND
> Short blurb about what your product does.

[![NPM Version][npm-image]][npm-url]
[![Build Status][travis-image]][travis-url]
[![Downloads Stats][npm-downloads]][npm-url]

- Leitura dos arquivos de Controle de Transporte, Livros fiscais e notas fiscais eletrônicas.
- Envio dos dados tratados para o Banco de dados (MongoDB) 

![](header.png)

## Installation

OS X & Linux:

```sh
instalation steps
```


## How to run

```sh
   mvn spring-boot:run 
```

1. recompilar o projeto usando o pom
2. executar  a classe SncFeApiApplication da pasta br.com.sped.scf
3. o serviço estará disponivel no endereço  /api/consulta-doc-divergente-contribuinte da classe 
   br.com.sped.scf.api.resource.ConsultarDocDivergentePorContrResource
exemplo http://localhost:8080/api/consulta-doc-divergente-contribuinte?cnpj=59373293746768&ano=2020&mes=07


_For more examples and usage, please refer to the [Wiki][wiki]._

## Development setup

Describe how to install all development dependencies and how to run an automated test-suite of some kind. Potentially do this for multiple platforms.

####Dependencies:
* Java -Qual versão
* MongoDB
* Etc

```sh
make install
npm test
```

## Meta

Your Name – [@YourTwitter](https://twitter.com/dbader_org) – YourEmail@example.com

Distributed under the XYZ license. See ``LICENSE`` for more information.

[https://github.com/yourname/github-link](https://github.com/dbader/)

## Contributing

1. Fork it (<https://github.com/yourname/yourproject/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request

<!-- Markdown link & img dfn's -->
[npm-image]: https://img.shields.io/npm/v/datadog-metrics.svg?style=flat-square
[npm-url]: https://npmjs.org/package/datadog-metrics
[npm-downloads]: https://img.shields.io/npm/dm/datadog-metrics.svg?style=flat-square
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics
[wiki]: https://github.com/yourname/yourproject/wiki