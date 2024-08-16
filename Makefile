run:
	docker compose -f compose.base.yaml -f compose.product.yaml -f compose.sales.yaml -f compose.auth.yaml up
