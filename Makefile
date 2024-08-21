run:
	docker compose -f compose.base.yaml -f compose.product.yaml -f compose.sales.yaml -f compose.auth.yaml -f compose.rabbit.yaml up

product:
	docker compose -f compose.base.yaml -f compose.rabbit.yaml -f compose.product.yaml up

sales:
	docker compose -f compose.rabbit.yaml -f docker.sales.yaml up
